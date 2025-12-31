package net.irq3.blog.utils;

import jakarta.persistence.AttributeConverter;
import net.irq3.blog.models.Permissions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermissionConverter implements AttributeConverter<List<Permissions>, String> {
    @Override public String convertToDatabaseColumn(List<Permissions> permissions) {
        return permissions.stream().map(Enum::name).collect(Collectors.joining(","));
    }

    @Override public List<Permissions> convertToEntityAttribute(String s) {
        String[] array = s.split(",");
        return Arrays.stream(array)
                .map(a -> Permissions.valueOf(a.trim()))
                .collect(Collectors.toList());
    }
}

package za.co.javaspace.developerstarter.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DefaultDeveloper implements DeveloperService {

    private String name;

    @Override
    public String name() {
        return name;
    }
}

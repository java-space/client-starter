package za.co.javaspace.developerstarter.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum WebPage {

    HOME("index"),
    DEVELOPER("developer"),
    DEVELOPERS("developers");

    @Getter
    private final String pageName;

    @Override
    public String toString() {
        return getPageName();
    }
}

package za.co.javaspace.developerstarter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperDetails {

    private String name;
    private String language;
    private String experience;

}

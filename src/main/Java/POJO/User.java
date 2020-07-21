package POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User
{
    private String username;
    private String mm;
    private int permission;
    private int primary_key;
    private int pass;

}

package POJO;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User
{
    private String username;
    private String mm;
    private int permission;
    private int primary_key;
    private int pass;

}

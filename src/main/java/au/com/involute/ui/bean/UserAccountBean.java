package au.com.involute.ui.bean;

import au.com.involute.data.entity.UserAccountEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserAccountBean
{
    private Long id;

    @NotNull(message = "The field username must be provided.")
    @Size(min = 1, message = "The field username must be longer than 1 character.")
    private String username;

    @NotNull(message = "The field password must be provided.")
    @Size(min = 1, message = "The field password must be longer than 1 character.")
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getFullName()
    {
        StringBuilder builder = new StringBuilder();

        if (this.firstName != null) {
            builder.append(this.firstName);
        }

        if (this.lastName != null) {
            builder.append(" ")
                    .append(this.lastName);
        }

        return builder.toString().trim();
    }

    public static UserAccountBean fromEntity(UserAccountEntity entity)
    {
        UserAccountBean bean = new UserAccountBean();

        bean.setId(entity.getId());
        bean.setUsername(entity.getUsername());
        bean.setPassword(entity.getPassword());
        bean.setEmail(entity.getEmail());
        bean.setFirstName(entity.getFirstName());
        bean.setLastName(entity.getLastName());

        return bean;
    }

    public UserAccountEntity toEntity()
    {
        UserAccountEntity entity = new UserAccountEntity();

        entity.setId(this.getId());
        entity.setUsername(this.getUsername());
        entity.setPassword(this.getPassword());
        entity.setEmail(this.getEmail());
        entity.setFirstName(this.getFirstName());
        entity.setLastName(this.getLastName());

        return entity;
    }
}
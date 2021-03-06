package views.formdata;

import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;
import models.UserInfoDB;

/**
 * Backing class for the login form.
 */
public class LoginFormData {

  /** The submitted email. */
  public String email = "";
  /** The submitted password. */
  public String password = "";
  
  public ValidationError GlobalError;
  public boolean hasGlobalErrors = false;

  /** Required for form instantiation. */
  public LoginFormData() {
  }

  /**
   * Validates Form<LoginFormData>.
   * Called automatically in the controller by bindFromRequest().
   * Checks to see that email and password are valid credentials.
   * @return Null if valid, or a List[ValidationError] if problems found.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();
    
    if (!UserInfoDB.isValid(email, password)) {
      errors.add(new ValidationError("email", ""));
      errors.add(new ValidationError("password", ""));      
    }

    if (errors.size() > 0){
        GlobalError = errors.get(0);
        hasGlobalErrors = true;
    }
    return (errors.size() > 0) ? errors : null;
  }
  
  public ValidationError GlobalError(){
      List<ValidationError> errors = validate();
      if (errors.size() > 0) return errors.get(0);
      return null;
  }
  
  public boolean hasGlobalErrors(){
      List<ValidationError> errors = validate();
      if (errors.size() > 0) return true;
      return false;
  }

}
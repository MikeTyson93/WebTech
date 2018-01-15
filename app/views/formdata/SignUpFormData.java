package views.formdata;

import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;
import models.UserInfoDB;

/**
 * Backing class for the sign up form.
 */
public class SignUpFormData {

  /** The submitted email. */
  public String email = "";
  /** The submitted password. */
  public String password = "";
  
  public ValidationError GlobalError;
  public boolean hasGlobalErrors = false;

  /** Required for form instantiation. */
  public SignUpFormData() {
  }

  /**
   * Validates Form<SignUpFormData>.
   * Called automatically in the controller by bindFromRequest().
   * Checks to see that email and password are valid credentials.
   * @return Null if valid, or a List[ValidationError] if problems found.
   */
  public List<ValidationError> validate() {

    return null;
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
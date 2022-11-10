import data.AuthData;
import data.PostData;
import org.junit.Test;

public class AuthTest extends TestBase {
  private static final AuthData authData = new AuthData("terentyeevaolga@gmail.com", "Aser4321");
  public static final PostData postData = new PostData("сделать домашку");

  @Test
  public void auth() throws InterruptedException {
    OpenURL();
    SetSize();
    EnterData(authData);
  }

  @Test
  public void createNewPost() throws InterruptedException {
    OpenURL();
    SetSize();
    EnterData(authData);
    CreateTask(postData);
  }
}

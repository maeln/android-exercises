package fr.android.androidexercises;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by maeln on 21/02/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
    @Mock LoginActivity activity;
    @InjectMocks LoginPresenter presenter;

    @Test
    public void goodCredentials() throws Exception {
        presenter.checkCredentials("password");
        Mockito.verify(activity).logged();
        Mockito.verify(activity).message(R.string.text_logged);
    }

    @Test
    public void badCredentials() throws Exception {
        presenter.checkCredentials("b");
        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }

    @Test
    public void nullCredentials() throws Exception {
        presenter.checkCredentials(null);
        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }
}
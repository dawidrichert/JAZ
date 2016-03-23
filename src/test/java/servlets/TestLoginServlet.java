package servlets;

import com.dawidrichert.servlets.LoginServlet;
import com.dawidrichert.utils.Resources;
import com.dawidrichert.viewModels.LoginViewModel;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TestLoginServlet extends Mockito {

    @Test
    public void post_Should_ReturnError_When_EnteredEmptyData() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        LoginServlet servlet = new LoginServlet();

        when(request.getParameter(LoginViewModel.userNameKey)).thenReturn("");
        when(request.getParameter(LoginViewModel.passwordKey)).thenReturn("");
        when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute(eq("errorMessage"), Mockito.anyString());
    }

    @Test
    public void post_Should_ReturnError_When_CredentialsAreIncorrect() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        LoginServlet servlet = new LoginServlet();

        when(request.getParameter(LoginViewModel.userNameKey)).thenReturn("tester");
        when(request.getParameter(LoginViewModel.passwordKey)).thenReturn("tester");
        when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute(eq("errorMessage"), Mockito.anyString());
    }

    @Test
    public void post_Should_RedirectToUserProfile_When_CredentialsAreCorrect() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        HttpSession httpSession = mock(HttpSession.class);
        LoginServlet servlet = new LoginServlet();

        when(request.getParameter(LoginViewModel.userNameKey)).thenReturn("john");
        when(request.getParameter(LoginViewModel.passwordKey)).thenReturn("potato");
        when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);
        when(request.getSession()).thenReturn(httpSession);

        servlet.doPost(request, response);

        verify(response).sendRedirect(Resources.userProfileUrl);
    }
}

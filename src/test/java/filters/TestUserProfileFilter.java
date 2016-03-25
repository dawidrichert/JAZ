package filters;

import com.dawidrichert.filters.UserProfileFilter;
import com.dawidrichert.utils.Resources;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TestUserProfileFilter extends Mockito {

    @Test
    public void get_Should_RedirectToNoAccessPage_When_UserIsNotLogged() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        HttpSession httpSession = mock(HttpSession.class);
        FilterChain filterChain = mock(FilterChain.class);
        UserProfileFilter filter = new UserProfileFilter();

        when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);
        when(request.getSession()).thenReturn(httpSession);

        filter.doFilter(request, response, filterChain);

        verify(request).getRequestDispatcher(Resources.noAccessJsp);
    }
}

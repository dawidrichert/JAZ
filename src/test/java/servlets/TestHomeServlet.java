package servlets;

import com.dawidrichert.servlets.HomeServlet;
import com.dawidrichert.utils.Resources;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestHomeServlet extends Mockito {

    @Test
    public void get_ShouldForward_ToHomeJsp() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        HomeServlet servlet = new HomeServlet();

        when(request.getParameter("city")).thenReturn("Warszawa");
        when(request.getRequestDispatcher(Resources.homeJsp)).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(request).getRequestDispatcher(Resources.homeJsp);
        verify(requestDispatcher).forward(request, response);
    }
}

package servlets;

import com.dawidrichert.models.CreditData;
import com.dawidrichert.servlets.ScheduleServlet;
import com.dawidrichert.utils.Resources;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestScheduleServlet extends Mockito {

    @Test
    public void post_ShouldSet_ErrorAttribute_When_EnteredInvalid_RequestedCreditAmount() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        ScheduleServlet servlet = new ScheduleServlet();

        when(request.getParameter(CreditData.requestedCreditAmountKey)).thenReturn("InvalidTypeOfData");
        when(request.getParameter(CreditData.installmentsNumberKey)).thenReturn("120");
        when(request.getParameter(CreditData.rateOfInterestKey)).thenReturn("5");
        when(request.getParameter(CreditData.fixedFeeKey)).thenReturn("5");
        when(request.getParameter(CreditData.installmentsTypeKey)).thenReturn("1");
        when(request.getRequestDispatcher(Resources.IndexJsp)).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute("error", true);
    }

    @Test
    public void post_ShouldSet_ErrorAttribute_When_EnteredInvalid_InstallmentsNumber() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        ScheduleServlet servlet = new ScheduleServlet();

        when(request.getParameter(CreditData.requestedCreditAmountKey)).thenReturn("5000");
        when(request.getParameter(CreditData.installmentsNumberKey)).thenReturn("InvalidTypeOfData");
        when(request.getParameter(CreditData.rateOfInterestKey)).thenReturn("5");
        when(request.getParameter(CreditData.fixedFeeKey)).thenReturn("5");
        when(request.getParameter(CreditData.installmentsTypeKey)).thenReturn("1");
        when(request.getRequestDispatcher(Resources.IndexJsp)).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute("error", true);
    }

    @Test
    public void post_ShouldSet_ErrorAttribute_When_EnteredInvalid_RateOfInterest() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        ScheduleServlet servlet = new ScheduleServlet();

        when(request.getParameter(CreditData.requestedCreditAmountKey)).thenReturn("5000");
        when(request.getParameter(CreditData.installmentsNumberKey)).thenReturn("120");
        when(request.getParameter(CreditData.rateOfInterestKey)).thenReturn("InvalidTypeOfData");
        when(request.getParameter(CreditData.fixedFeeKey)).thenReturn("5");
        when(request.getParameter(CreditData.installmentsTypeKey)).thenReturn("1");
        when(request.getRequestDispatcher(Resources.IndexJsp)).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute("error", true);
    }

    @Test
    public void post_ShouldSet_ErrorAttribute_When_EnteredInvalid_FixedFee() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        ScheduleServlet servlet = new ScheduleServlet();

        when(request.getParameter(CreditData.requestedCreditAmountKey)).thenReturn("5000");
        when(request.getParameter(CreditData.installmentsNumberKey)).thenReturn("120");
        when(request.getParameter(CreditData.rateOfInterestKey)).thenReturn("5");
        when(request.getParameter(CreditData.fixedFeeKey)).thenReturn("InvalidTypeOfData");
        when(request.getParameter(CreditData.installmentsTypeKey)).thenReturn("1");
        when(request.getRequestDispatcher(Resources.IndexJsp)).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute("error", true);
    }

    @Test
    public void post_ShouldSet_ErrorAttribute_When_EnteredInvalid_InstallmentsType() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        ScheduleServlet servlet = new ScheduleServlet();

        when(request.getParameter(CreditData.requestedCreditAmountKey)).thenReturn("5000");
        when(request.getParameter(CreditData.installmentsNumberKey)).thenReturn("120");
        when(request.getParameter(CreditData.rateOfInterestKey)).thenReturn("5");
        when(request.getParameter(CreditData.fixedFeeKey)).thenReturn("5");
        when(request.getParameter(CreditData.installmentsTypeKey)).thenReturn("InvalidTypeOfData");
        when(request.getRequestDispatcher(Resources.IndexJsp)).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute("error", true);
    }

    @Test
    public void post_ShouldSet_ErrorAttribute_When_EnteredEmptyData() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        ScheduleServlet servlet = new ScheduleServlet();

        when(request.getParameter(CreditData.requestedCreditAmountKey)).thenReturn("");
        when(request.getParameter(CreditData.installmentsNumberKey)).thenReturn("");
        when(request.getParameter(CreditData.rateOfInterestKey)).thenReturn("");
        when(request.getParameter(CreditData.fixedFeeKey)).thenReturn("");
        when(request.getParameter(CreditData.installmentsTypeKey)).thenReturn("");
        when(request.getRequestDispatcher(Resources.IndexJsp)).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute("error", true);
    }

    @Test
    public void post_ShouldSet_ErrorAttribute_When_NoDataEntered() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        ScheduleServlet servlet = new ScheduleServlet();

        when(request.getParameter(CreditData.requestedCreditAmountKey)).thenReturn(null);
        when(request.getParameter(CreditData.installmentsNumberKey)).thenReturn(null);
        when(request.getParameter(CreditData.rateOfInterestKey)).thenReturn(null);
        when(request.getParameter(CreditData.fixedFeeKey)).thenReturn(null);
        when(request.getParameter(CreditData.installmentsTypeKey)).thenReturn(null);
        when(request.getRequestDispatcher(Resources.IndexJsp)).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute("error", true);
    }

    @Test
    public void post_ShouldForward_ToPaymentsScheduleJsp_When_EnteredDataAreCorrect() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        ScheduleServlet servlet = new ScheduleServlet();

        when(request.getParameter(CreditData.requestedCreditAmountKey)).thenReturn("5000");
        when(request.getParameter(CreditData.installmentsNumberKey)).thenReturn("120");
        when(request.getParameter(CreditData.rateOfInterestKey)).thenReturn("5");
        when(request.getParameter(CreditData.fixedFeeKey)).thenReturn("5");
        when(request.getParameter(CreditData.installmentsTypeKey)).thenReturn("1");
        when(request.getRequestDispatcher(Resources.PaymentsScheduleJsp)).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).getRequestDispatcher(Resources.PaymentsScheduleJsp);
        verify(requestDispatcher).forward(request, response);
    }
}

package servlets;

import com.dawidrichert.models.CalculationData;
import com.dawidrichert.servlets.CalculateServlet;
import com.dawidrichert.utils.Resources;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestCalculateServlet extends Mockito {

    @Test
    public void post_ShouldSet_ErrorAttribute_When_EnteredInvalid_ContractType() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        CalculateServlet servlet = new CalculateServlet();

        when(request.getParameter(CalculationData.contractTypeKey)).thenReturn("InvalidTypeOfData");
        when(request.getParameter(CalculationData.yearKey)).thenReturn("2016");
        when(request.getParameter(CalculationData.salaryKey)).thenReturn("5000");
        when(request.getParameter(CalculationData.payTypeKey)).thenReturn("0");
        when(request.getParameter(CalculationData.disabilityContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.pensionContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.sicknessContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.healthCareContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.deductibleCostsKey)).thenReturn("0");
        when(request.getRequestDispatcher(Resources.indexJsp)).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute("error", true);
    }

    @Test
    public void post_ShouldSet_ErrorAttribute_When_EnteredInvalid_Year() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        CalculateServlet servlet = new CalculateServlet();

        when(request.getParameter(CalculationData.contractTypeKey)).thenReturn("0");
        when(request.getParameter(CalculationData.yearKey)).thenReturn("InvalidTypeOfData");
        when(request.getParameter(CalculationData.salaryKey)).thenReturn("5000");
        when(request.getParameter(CalculationData.payTypeKey)).thenReturn("0");
        when(request.getParameter(CalculationData.disabilityContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.pensionContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.sicknessContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.healthCareContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.deductibleCostsKey)).thenReturn("0");
        when(request.getRequestDispatcher(Resources.indexJsp)).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute("error", true);
    }

    @Test
    public void post_ShouldSet_ErrorAttribute_When_EnteredInvalid_Salary() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        CalculateServlet servlet = new CalculateServlet();

        when(request.getParameter(CalculationData.contractTypeKey)).thenReturn("0");
        when(request.getParameter(CalculationData.yearKey)).thenReturn("2016");
        when(request.getParameter(CalculationData.salaryKey)).thenReturn("InvalidTypeOfData");
        when(request.getParameter(CalculationData.payTypeKey)).thenReturn("0");
        when(request.getParameter(CalculationData.disabilityContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.pensionContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.sicknessContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.healthCareContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.deductibleCostsKey)).thenReturn("0");
        when(request.getRequestDispatcher(Resources.indexJsp)).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute("error", true);
    }

    @Test
    public void post_ShouldSet_ErrorAttribute_When_EnteredInvalid_PayType() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        CalculateServlet servlet = new CalculateServlet();

        when(request.getParameter(CalculationData.contractTypeKey)).thenReturn("0");
        when(request.getParameter(CalculationData.yearKey)).thenReturn("2016");
        when(request.getParameter(CalculationData.salaryKey)).thenReturn("5000");
        when(request.getParameter(CalculationData.payTypeKey)).thenReturn("InvalidTypeOfData");
        when(request.getParameter(CalculationData.disabilityContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.pensionContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.sicknessContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.healthCareContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.deductibleCostsKey)).thenReturn("0");
        when(request.getRequestDispatcher(Resources.indexJsp)).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute("error", true);
    }

    @Test
    public void post_ShouldSet_ErrorAttribute_When_EnteredEmptyData() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        CalculateServlet servlet = new CalculateServlet();

        when(request.getParameter(CalculationData.contractTypeKey)).thenReturn("");
        when(request.getParameter(CalculationData.yearKey)).thenReturn("");
        when(request.getParameter(CalculationData.salaryKey)).thenReturn("");
        when(request.getParameter(CalculationData.payTypeKey)).thenReturn("");
        when(request.getParameter(CalculationData.disabilityContributionKey)).thenReturn("");
        when(request.getParameter(CalculationData.pensionContributionKey)).thenReturn("");
        when(request.getParameter(CalculationData.sicknessContributionKey)).thenReturn("");
        when(request.getParameter(CalculationData.healthCareContributionKey)).thenReturn("");
        when(request.getParameter(CalculationData.deductibleCostsKey)).thenReturn("");
        when(request.getRequestDispatcher(Resources.indexJsp)).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute("error", true);
    }

    @Test
    public void post_ShouldSet_ErrorAttribute_When_NoDataEntered() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        CalculateServlet servlet = new CalculateServlet();

        when(request.getParameter(CalculationData.contractTypeKey)).thenReturn(null);
        when(request.getParameter(CalculationData.yearKey)).thenReturn(null);
        when(request.getParameter(CalculationData.salaryKey)).thenReturn(null);
        when(request.getParameter(CalculationData.payTypeKey)).thenReturn(null);
        when(request.getParameter(CalculationData.disabilityContributionKey)).thenReturn(null);
        when(request.getParameter(CalculationData.pensionContributionKey)).thenReturn(null);
        when(request.getParameter(CalculationData.sicknessContributionKey)).thenReturn(null);
        when(request.getParameter(CalculationData.healthCareContributionKey)).thenReturn(null);
        when(request.getParameter(CalculationData.deductibleCostsKey)).thenReturn(null);
        when(request.getRequestDispatcher(Resources.indexJsp)).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute("error", true);
    }

    @Test
    public void post_ShouldForward_ToPaymentsScheduleJsp_When_EnteredDataAreCorrect() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        CalculateServlet servlet = new CalculateServlet();

        when(request.getParameter(CalculationData.contractTypeKey)).thenReturn("0");
        when(request.getParameter(CalculationData.yearKey)).thenReturn("2016");
        when(request.getParameter(CalculationData.salaryKey)).thenReturn("5000");
        when(request.getParameter(CalculationData.payTypeKey)).thenReturn("0");
        when(request.getParameter(CalculationData.disabilityContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.pensionContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.sicknessContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.healthCareContributionKey)).thenReturn("true");
        when(request.getParameter(CalculationData.deductibleCostsKey)).thenReturn("0");
        when(request.getRequestDispatcher(Resources.resultJsp)).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(request).getRequestDispatcher(Resources.resultJsp);
        verify(requestDispatcher).forward(request, response);
    }
}

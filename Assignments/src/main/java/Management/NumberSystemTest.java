package Management;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class NumberSystemTest {

    private NumberSystem numberSystemServlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @BeforeEach
    public void setUp() {
        numberSystemServlet = new NumberSystem();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        // Set up request parameters
        request.addParameter("system", "dec");
        request.addParameter("input1", "5");
        request.addParameter("input2", "3");

        // Call the doPost method
        numberSystemServlet.doPost(request, response);

        // Verify the response
        String result = (String) request.getAttribute("result");
        String expectedDecResult = "8";
        // Replace the expected result with the result you expect based on your logic
        // Add similar checks for other cases

        // Assert the result
        assert response.getStatus() == HttpServletResponse.SC_OK;
        assert result.equals(expectedDecResult);
    }
}

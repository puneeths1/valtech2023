
package Management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/TagCounterServlets")
@MultipartConfig
public class TagCounterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("tagcountresult.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Part filePart = request.getPart("htmlFile");
            InputStream fileContent = filePart.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent));
            Map<String, Integer> tagCount = new HashMap<>();
            String line;

            while ((line = reader.readLine()) != null) {
                Pattern pattern = Pattern.compile("<(\\w+)[^>]*>");
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    String tag = matcher.group(1);
                    tagCount.put(tag, tagCount.getOrDefault(tag, 0) + 1);
                }
            }

            request.setAttribute("tagCount", tagCount);
            request.getRequestDispatcher("tagcountresult.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("An error occurred: " + e.getMessage());
        }
    }
}

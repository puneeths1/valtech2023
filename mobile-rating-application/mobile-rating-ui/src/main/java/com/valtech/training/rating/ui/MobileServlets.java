package com.valtech.training.rating.ui;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valtech.training.mobileranking.MobileRankingService;
import com.valtech.training.pattern.checker.PatternCheckerServiceImpl;

//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

//import com.valtech.training.pattern.checker.PatternCheckerServiceImpl;
//import com.valtech.training.rating.ui.RatingHelper;

// Import necessary classes

//import com.valtech.training.pattern.checker.PatternCheckerServiceImpl;
//import com.valtech.training.rating.ui.RatingHelper;

// Import necessary classes

import com.valtech.training.pattern.checker.PatternCheckerServiceImpl;
import com.valtech.training.rating.ui.RatingHelper;

// Import necessary classes

public class MobileServlets extends HttpServlet {
    private PatternCheckerServiceImpl patternCheckerService;
    private RatingHelper ratingHelper;

    @Override
    public void init() throws ServletException {
        patternCheckerService = new PatternCheckerServiceImpl();
        // Initialize ratingHelper with the MobileRankingService
//        ServletContext coontext = getServletContext();
//        ratingHelper = new RatingHelper((MobileRankingService)coontext.getAttribute("MobileRankingService"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET request here
        String mobileNumber = request.getParameter("mobile");

        // Process the mobile number and set attributes as needed
        processMobileNumber(mobileNumber, request);

        // Forward the request to the JSP
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST request here
        String mobileNumber = request.getParameter("mobile");

        // Process the mobile number and set attributes as needed
        processMobileNumber(mobileNumber, request);

        // Forward the request to the JSP
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    private void processMobileNumber(String mobileNumber, HttpServletRequest request) {
        if (mobileNumber != null && !mobileNumber.isEmpty()) {
            List<String> patterns = patternCheckerService.listPatterns(Arrays.asList(mobileNumber));
            int rating = ratingHelper.getRating(mobileNumber);

            // Set attributes in the request object
            request.setAttribute("patterns", patterns);
            request.setAttribute("rating", rating);
        }
    }
}



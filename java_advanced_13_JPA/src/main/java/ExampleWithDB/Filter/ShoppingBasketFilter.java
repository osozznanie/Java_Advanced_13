package ExampleWithDB.Filter;

import ExampleWithDB.shop.AccessLevel;
import ExampleWithDB.shop.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter("/shoppingBasket.jsp")
public class ShoppingBasketFilter implements Filter {
    private FilterService filterService = FilterService.getFilterService();

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        filterService.doFilterValidation(req, resp, chain, Arrays.asList(AccessLevel.USER));
        System.out.println(2);

    }

}



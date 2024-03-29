package it.hermione.mvc;

import junit.framework.TestCase;

import org.springframework.web.servlet.ModelAndView;

public class HelloControllerTests extends TestCase {

	public void testHandleRequestView() throws Exception {
		HelloController controller = new HelloController();
        ModelAndView modelAndView = controller.handleRequest(null, null);
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        String nowValue = (String) modelAndView.getModel().get("now");
        assertNotNull(nowValue);
	}
}

package com.cdv.test.mybatis;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ServletToBeanProxy extends GenericServlet {

    private static final long serialVersionUID = -6841906526208019964L;

    // ��ǰ�ͻ��������Servlet����
    private String targetBean;

    // ����Servlet
    private Servlet proxy;

    @Override
    public void init() throws ServletException {
        super.init();
        // ��ʼ��Spring����
        WebApplicationContext wac = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        
        // ��ȡServlet��
        this.targetBean = getServletName();
        // ����ServletBean
        this.proxy = (Servlet) wac.getBean(targetBean);
        // ���ó�ʼ��������ServletConfig����Bean
        proxy.init(getServletConfig());
    }

    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        // ��service�����е���bean��service������servlet����ݿͻ�������ȥ������Ӧ�����󷽷�(Get/Post)
        proxy.service(request, response);
    }
}

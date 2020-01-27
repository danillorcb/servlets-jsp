# Servlet e JSP

> CRUD básico usando os fundamentos de Servlet e JSP.

> Uso de JSTL com Expression Language no JSP.

> Aplicação de redirecionamento Client-Side (response.sendRedirect()) e Server-Side (RequestDispatcher).

> Aplicação do Pattern Command para direcionamento das ações na [Servlet](https://github.com/danillorcb/servlets-jsp/blob/master/src/br/com/danillorcb/servlets/servlet/EntradaServlet.java) principal. 

### Autenticação com HttpSession
Através do request.getSession() recuperamos um HttpSession, no qual podemos pendurar atributos, assim como no request, porém agora duradouros.

Para alterar o tempo da sessão:
```
<session-config>
    <session-timeout>10</session-timeout>
</session-config>
```

### Aplicação com uso de Filter
O filtro consegue parar a execução, já que ele vem como uma camada à frente da aplicação.
Essa é a diferença que podemos ver no nosso código, através do parâmetro FilterChain. 
Usamos o FilterChain para mandar a requisição para frente.

**Configurando pelo web.xml (para especificar ordem dos filtros)**
```
<filter>
	<filter-name>AF</filter-name>
	<filter-class>br.com.danillorcb.servlets.servlet.AutorizacaoFilter</filter-class>
</filter>
<filter-mapping>
	<filter-name>AF</filter-name>
	<url-pattern>/entrada</url-pattern>
</filter-mapping>
```



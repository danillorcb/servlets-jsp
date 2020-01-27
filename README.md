# Servlet e JSP

> CRUD b�sico usando os fundamentos de Servlet e JSP.

> Uso de JSTL com Expression Language no JSP.

> Aplica��o de redirecionamento Client-Side (response.sendRedirect()) e Server-Side (RequestDispatcher).

> Aplica��o do Pattern Command para direcionamento das a��es na [Servlet](https://github.com/danillorcb/servlets-jsp/blob/master/src/br/com/danillorcb/servlets/servlet/EntradaServlet.java) principal. 

### Autentica��o com HttpSession
Atrav�s do request.getSession() recuperamos um HttpSession, no qual podemos pendurar atributos, assim como no request, por�m agora duradouros.

Para alterar o tempo da sess�o:
```
<session-config>
    <session-timeout>10</session-timeout>
</session-config>
```

### Aplica��o com uso de Filter
O filtro consegue parar a execu��o, j� que ele vem como uma camada � frente da aplica��o.
Essa � a diferen�a que podemos ver no nosso c�digo, atrav�s do par�metro FilterChain. 
Usamos o FilterChain para mandar a requisi��o para frente.

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



<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="titulo" required="true"%>
<%@ attribute name="bodyClass" required="false"%>

<body class="${bodyClass}"></body>
	<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
	<jsp:doBody />
	<%@ include file="/WEB-INF/views/rodape.jsp"%>
</body>
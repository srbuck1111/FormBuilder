<%-- #RevizeProperties USE REVIZE MENU (DOCUMENT PROPERTIES) TO EDIT DATA BELOW:
status=new
options=
server=localhost:80
projectName=
label=
location=
version=
docType=editpage
subType=form
moduleName=
fieldName=
channels=|
description=
--%><%-- #BeginRZ-PageHeader --%>
<%@ page language="java" %>
<% String rzmodule = "#MODULENAME#";%>
<%@ include file="/util/setup_editform_header.jsp"%>
<%-- #EndRZ-PageHeader --%>
<%@ include file="/plugins/_editforms_/v2/includes/bootstrap.jsp"%>
<%
  formTitle = "#FORMTITLE#";
  headerClass = "col-md-8 col-md-offset-2";
  moduleName = "#MODULENAME#";
  historyStr = "#HISTORYSTRING#";
%>
<%@ include file="/plugins/_editforms_/v2/includes/header.jsp"%>
<div id="revize-main">
	<!-- Make use to add name="XMLForm" and the hidden XMLString field -->
	<form id="rz-form" name="XMLForm" method="post" action="">
		<input name="XMLString" type="hidden" />
		<%@ include file="/plugins/_editforms_/v2/includes/editform-buttons-top.jsp"%>
		<div class="form-container">
			<div class="container">
				<div class="row">
					<div class="<%=headerClass%>">
						<div class="tab-content rz-tab-content">
							<div role="tabpanel" class="tab-pane rz-tab-pane fade in active" id="edit-tab">
								<div class="edit-form-fields">
                                    #EDITFIELDS#
								</div><!-- /.edit-form-fields -->
							<%@ include file="/plugins/_editforms_/v2/includes/editform-buttons-bottom.jsp"%>
						</div><!-- /tab-content -->
					</div><!-- /.col-md-8 -->
				</div><!-- /.row -->
			</div><!-- /.container -->
		</div><!-- /.form-container -->
	</form>
</div><!-- /#revize-main -->
</div><!-- /#revize-main-wrap -->
<%@ include file="/plugins/_editforms_/v2/includes/scripts.jsp"%>
<%-- Custom Scripts can be added here after the standard scripts --%>
<%@ include file="/plugins/_editforms_/v2/includes/footer.jsp"%>
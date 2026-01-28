<%-- #RevizeProperties USE REVIZE MENU (DOCUMENT PROPERTIES) TO EDIT DATA BELOW:
status=new
options=
server=localhost:80
projectName=
label=
location=
version=
docType=editpage
subType=list
moduleName=
fieldName=
channels=|
description=Image Link Editlist
--%><%-- #BeginRZ-PageHeader --%>
<%@ page language="java" %>
<%@ include file="/util/setup_editlist_header.jsp"%>
<%-- #EndRZ-PageHeader --%>
<%@ include file="/plugins/_editforms_/v2/includes/bootstrap.jsp"%>
<%
  formTitle = "#FORMTITLE#";
  pageid = request.getParameter("pageid") == null ? null : request.getParameter("pageid").replaceAll("[^\\w\\d_-]", "");
  moduleName = "#MODULENAME#";
%>
<%@ include file="/plugins/_editforms_/v2/includes/editlist-header.jsp"%>
<div id="revize-main">
  <form id="rz-form" name="XMLForm" method="post" action="">
    <input name="XMLString" type="hidden" />
    <div class="rz-form-title">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1><%=formTitle%></h1>
            <div id="rz-right-btns" class="clearfix">
              <div id="add-item-btn">
                <script language="JavaScript" type="text/JavaScript">
                  RZ.module = '<%=moduleName%>'; RZ.linkname = '';
                  RZ.template = '*none*'; RZ.recordid = 'new';
                  RZ.nexturl = "#MODULENAME#-editform.jsp";
                  RZ.popupwidth = ''; RZ.popupheight = ''; RZ.popupscroll = '';
                  RZ.img = '<span class="btn btn-success rz-btn rz-btn-primary">Add Item</span>';
                  RZ.set = '<%=moduleName%>.pageid=<%=pageid%>';
                  RZ.options = '';
                  if (typeof RZaction != 'undefined') RZaction('newitem');
                </script>
              </div>
              <div id="exit-btn">
                <script language="JavaScript" type="text/JavaScript">
                  RZ.nexturl = '';
                  RZ.img = '<span class="btn btn-success rz-btn rz-btn-danger">Exit Page</span>';
                  RZ.options = '';
                  if (typeof RZaction != 'undefined') RZaction('exit');
                </script>
              </div>
            </div><!-- /#right-btns -->
            <%@ include file="/plugins/_editforms_/v2/includes/tabs.jsp"%>
          </div><!-- /.col-md-12 -->
        </div><!-- /.row -->
      </div><!-- /.container -->
    </div><!-- /.rz-form-title -->
    <div class="form-container">
      <div class="container">
        <div class="row">
          <div class="col-sm-12">
            <div class="tab-content rz-tab-content">
              <div role="tabpanel" class="tab-pane rz-tab-pane fade in active" id="edit-tab">
                <div class="rz-editlist">
                  <div class="table-responsive">
                    <table class="table table-bordered table-hover rz-table">
                      <thead>
                        <tr>
                          #LISTHEADERS#
                          <th class="rz-edit-col">Edit <span class="btn btn-deafult btn-sm rz-btn rz-btn-sm rz-btn-round rz-btn-tooltip" data-toggle="tooltip" data-toggle="tooltip" data-placement="top" title="Editing options">?</span></th>
                        </tr>
                      </thead>
                      <tbody>
                        <rz:list module="<%=moduleName%>" sort="seq_no asc" output="none" options="" filter="<%="pageid="+pageid%>">
                          <% while ( rz.listnext() && rz.listindex >= 0 ){ %>
                            <rz:listbody>
                              <tr>
                                #LISTFIELDS#
                                <td class="rz-edit-cell">
                                  <a name="<%=rz.listmodule%>_rz<%=rz.listitemid()%>"></a>
                                  <script language="JavaScript" type="text/JavaScript">
                                    RZ.module = '<%=rz.listmodule%>'; RZ.linkname = '';
                                    RZ.template = '*none*'; RZ.recordid = '<%=rz.listitemid()%>';
                                    RZ.nexturl = "#MODULENAME#-editform.jsp?";
                                    RZ.popupwidth = ''; RZ.popupheight = ''; RZ.popupscroll = '';
                                    RZ.img = '<span class="btn btn-success btn-sm rz-btn rz-btn-success rz-btn-sm rz-btn-round" data-toggle="tooltip" data-placement="top" title="Click to edit this item"><i class="glyphicon glyphicon-pencil"></i></span>';
                                    RZ.set = '<%=rz.listmodule%>.pageid=<%=pageid%>';
                                    RZ.options = '';
                                    if (typeof RZaction != 'undefined') RZaction('edititem');
                                  </script>
                                  <script language="JavaScript" type="text/JavaScript">
                                    RZ.module = '<%=rz.listmodule%>';
                                    RZ.recordid = '<%=rz.listitemid()%>';
                                    RZ.name = 'RZdelete' + RZ.recordid;
                                    RZ.img = '<span class="btn btn-danger btn-sm rz-btn rz-btn-danger rz-btn-sm rz-btn-round" data-toggle="tooltip" data-placement="top" title="Click to delete this item"><i class="glyphicon glyphicon-remove"></i></span>';
                                    RZ.options = '';
                                    if (typeof RZaction != 'undefined') RZaction('delete');
                                  </script>
                                </td>
                              </tr>
                            </rz:listbody>
                          <%}%>
                        </rz:list>
                      </tbody>
                    </table>
                  </div>
                </div><!-- /.rz-editlist -->
                <%@ include file="/plugins/_editforms_/v2/includes/editlist-buttons-bottom.jsp" %>
              </div><!-- /.tab-pane -->
            </div><!-- /.tab-content -->
          </div><!-- /.col-sm-12 -->
        </div><!-- /.row -->
      </div><!-- /.container -->
    </div><!-- /.form-container -->
  </form><!-- /#rz-form -->
</div><!-- /#revize-main -->
<%@ include file="/plugins/_editforms_/v2/includes/scripts.jsp" %>
<%@ include file="/plugins/_editforms_/v2/includes/editlist-footer.jsp" %>

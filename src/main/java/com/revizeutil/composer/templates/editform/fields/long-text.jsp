                                    <div class="form-group form-group-lg rz-form-group rz-form-group-lg revize-textarea">
                                        <label for="pageContent">#FIELDTITLE#<small></small></label>
                                        <span style="background:#fff">
                                            <rz:fetch module="<%=moduleName%>" field="#FIELDNAME#" options="richtext" output="none">
                                            <input type="hidden" id="pageContent" class="form-control" name="#FIELDNAME#" />
                                            <script language="JavaScript" type="text/JavaScript">
                                                RZ.module = '<%=moduleName%>'; RZ.field = '#FIELDNAME#'; RZ.recordid = '';
                                                RZ.value = <%=StringUtils.convertHtmlForSource(rz.content)%>;
                                                RZ.width = '800'; RZ.height = '400';
                                                RZ.options = '&contentsize=true&ImgMap=false&SpellCheckAuto=true&EditFormWizard=true&Source=true';
                                                RZ.rtestyles = '-h1,-h3,-h4,-h5,-h6,-blockquote,-div,-superscript,-subscript,.header,.subheader,.btn';
                                                RZ.linkmodule = '';
                                                RZ.linkpathname = '';
                                                RZ.linktemplate = '';
                                                RZ.linkisnewfolder = '';
                                                RZ.filelocation = '/';
                                                RZ.imagelocation = '/';
                                                RZ.imagemaxwidth = '';
                                                RZ.imagemaxheight = '';
                                                RZ.imagemaxbytes = '';
                                                RZ.set = '';
                                                RZeditor();
                                            </script>
                                            </rz:fetch>
                                        </span>
                                        <span class="help-block rz-help-block">#HELPTEXT#</span>
                                    </div>
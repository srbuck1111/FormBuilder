                                    <%-- Switch the size recommendation depending on pageid is used --%>
                                    <rzt:image-specs
                                        width="#WIDTH#"
                                        height="#HEIGHT#"
                                    />
                                    <rz:fetch module="<%=moduleName%>" field="#FIELDNAME#" output="none" options="image,location=/,extensions="></rz:fetch>
                                    <%
                                        String img_src ="/revize/plugins/_editforms_/v2/images/placeholder.png";
                                        if(rz.src.indexOf("noimage.gif") == -1) {
                                            img_src = rz.src;
                                        }
                                    %>
                                    <rzt:image
                                        label="#FIELDTITLE#"
                                        field="#FIELDNAME#"
                                        src="<%=img_src%>"
                                        fileID="<%=rz.fileid%>"
                                        script="<%=rz.script%>"
                                    />
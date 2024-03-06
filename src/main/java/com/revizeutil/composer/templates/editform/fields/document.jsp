                                    <% rz.fetch(moduleName, "#FIELDNAME#","file,edit,location=,extensions="); %>
                                    <rzt:file
                                        label="#FIELDTITLE#"
                                        field="#FIELDNAME#"
                                        fileID="<%=rz.fileid%>"
                                        fileName="<%=rz.filename%>"
                                        script="<%=rz.script%>"
                                    />
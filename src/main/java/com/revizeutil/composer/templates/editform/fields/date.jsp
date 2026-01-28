									<rz:fetch module="<%=moduleName%>" field="#FIELDNAME#" output="none" format="MM/dd/yyyy" options="size=50,wrap=Virtual"/>
									<rzt:date-picker
										label="#FIELDTITLE#"
										field="#FIELDNAME#"
										content="<%=rz.content%>"
										help="#HELPTEXT#"
									/>
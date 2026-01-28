                                <td class="rz-image-cell">
                                    <rz:fetch module="<%=rz.listmodule%>" field="#FIELDNAME#" output="none" options="image,location=/,extensions="></rz:fetch>
                                    <% imageSrc = placeholderSrc; imageSrc = rz.src.indexOf("noimage.gif") == -1 ? rz.src : placeholderSrc; %>
                                    <rzt:image-display src="<%=imageSrc%>" />
                                </td>
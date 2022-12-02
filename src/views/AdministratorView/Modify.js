import React from "react"

function oModify(props){
  return(
    <div>
      <form>
        <fieldset>
          <legend>Modificar item</legend>
          <table>
            <tr>
              <td><label>Codigo:</label></td>
              <td><label>{props.value[0]}</label></td>
            </tr>
            <tr>
              <td><label>Nombre:</label></td>
              <td><input type="text" value={props.value[1]}/></td>
            </tr>
            <tr>
              <td><label>Descripcion:</label></td>
              <td><input type="text" value={props.value[2]}/></td>
            </tr>
            <tr>
              <td><label>Price:</label></td>
              <td><input type="text" value={props.value[3]}/></td>
            </tr>
            <tr>
              <td><input type="submit" value="modificar"/></td>
            </tr>
          </table>
        </fieldset>
      </form>
    </div>
  );
}

export default ToModify;
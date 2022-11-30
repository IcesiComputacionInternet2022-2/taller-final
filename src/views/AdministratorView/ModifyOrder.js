import React, {Component} from "react";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

class ModifyOrder extends Component{
  render(){
    return(
        <Container>
          <div class="search_bar">
            <Row>
              <form>
                <tr>
                  <td><input type="text" placeholder="Ingresa el nombre del item"/></td>
                  <td><input type="submit" value="Buscar"/></td>
                </tr>
              </form>            
            </Row>
          </div>
          <div class="search_result">
          </div>
        </Container>
    );
  }//End render
}//End ModifyItem

export default ModifyOrder;

import React from "react";
export default class Navbar extends React.Component{


    render(){
        return (
           <div>

               <nav className="navbar navbar-expand-lg  navbar-dark bg-dark fixed-top">
                   <div className="container-fluid">
                       <p className="navbar-brand" >Virtual E-store</p>
                       <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                               aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                           <span className="navbar-toggler-icon"></span>
                       </button>
                       <div className="collapse navbar-collapse" id="navbarNav">
                           <ul className="navbar-nav">

                               {this.props.options.map(e=><li className="nav-item">
                                   <p    className="nav-link active" aria-current="page" onClick={e.page}>{e.name} </p>
                               </li>)}

                           </ul>
                       </div>
                   </div>
               </nav>

              <div className="d-flex vh-100 pt-5">
                  {this.props.children}
              </div>
           </div>
        )
    }
}
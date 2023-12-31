import React, {Component} from 'react';

class Footer extends Component {

    render() {
        return (<footer className="bg-dark fixed-bottom" data-bs-theme="dark">
                <ul className="nav justify-content-center border-bottom pb-3 mb-3">
                    <li className="nav-item"><a href="#" className="nav-link px-2 text-muted">Home</a></li>
                    <li className="nav-item"><a href="#" className="nav-link px-2 text-muted">About Us</a></li>
                    <li className="nav-item"><a href="#" className="nav-link px-2 text-muted">Login</a></li>
                </ul>
                <p className="text-center text-muted">© 2024 Project Bit Group 4, Inc</p>
            </footer>);
    }
}

export default Footer;
import React, {Component} from 'react';

class Landing extends Component {
    render() {
        return (
            <div>
                <header style={{paddingLeft: 0}}>
                    <div
                        className='p-5 text-center bg-image'
                        style={{
                            backgroundImage: "url('https://c4.wallpaperflare.com/wallpaper/519/451/632/5bd32e6ea8a2b-wallpaper-preview.jpg')",
                            height: 500,
                            backgroundRepeat: 'no-repeat',
                            backgroundPosition: 'center',
                            backgroundSize: 'cover'
                        }}
                    ></div>
                    <div>
                        <div className='mask' style={{
                            backgroundColor: 'rgba(0, 0, 0, 0.6)',
                            position: 'fixed',
                            zIndex: 2,
                            width: '100%',
                            height: '460px',
                            top: '3%',
                            borderBottom: '4px solid green'
                        }}>
                            <div className='d-flex justify-content-center align-items-center h-100'>
                                <div className='text-white'>
                                    <h1 className='mb-3'>Heading</h1>
                                    <h4 className='mb-3'>Subheading</h4>
                                    <a className='btn btn-outline-light btn-lg' href='#!' role='button'>
                                        Call to action
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </header>
                <section className='row' style={{height: 500, borderBottom: '4px solid green'}}>
                    <div className='col pt-4'>
                        <h1 className='fw-bold'>
                            About the project
                        </h1>
                        <p className="sec2-p">
                            Lorem Ipsum is simply dummy text of the printing and typesetting
                            industry. Lorem Ipsum has been the industry's standard dummy text
                            ever since the 1500s, when an unknown printer took a galley of
                            type and scrambled it to make a type specimen book. It has
                            survived not only five centuries, but also the leap into
                            electronic typesetting, remaining essentially unchanged. It was
                            popularised in the 1960s with the release of Letraset sheets
                            containing Lorem Ipsum passages, and more recently with desktop
                            publishing software like Aldus PageMaker including versions of
                            Lorem Ipsum.
                        </p>
                    </div>
                    <div className='col'>
                        <div style={{
                            width: '100%', height: 496, backgroundImage: "url('https://wallpaperaccess.com/full/3770921.jpg')", clipPath: "polygon(15% 0, 100% 0, 100% 100%, 0 100%)" ,
                        }}></div>
                    </div>
                </section>
            </div>);
    }
}

export default Landing;
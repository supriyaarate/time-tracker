import React from 'react';

import Link from '@mui/material/Link';

const TextLink = (prop) => {

    /*Possible Values : 
    variant : h1,h2,h3,h4,h5,h6,subtitle1,subtitle2,body1,body2,button,caption,overline

    */

    return ( 
        <>
            <Link 
                href={prop.url} 
                variant={prop.variant}>
                {prop.text}
            </Link>
        </>
     );
}
 
export default TextLink;
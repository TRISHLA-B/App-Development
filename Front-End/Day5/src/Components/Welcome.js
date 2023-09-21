// WelcomeMessage.js

import React from 'react';
import { useSelector } from 'react-redux';

function WelcomeMessage() {
  const user = useSelector((state) => state.auth.user);

  return (
    <div>
      {user && <p>Welcome, {user.name}!</p>}
    </div>
  );
}

export default WelcomeMessage;

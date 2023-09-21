// RouteWrapper.js
import React from 'react';
import Header from './Header'; // Import your Header component
import Sidebar from './Siderbar'; // Import your Sidebar component

function RouteWrapper({ children }) {
  return (
    <div className="app-container">
      <Header />
      <div className="content-container">
        <Sidebar />
        <main className="main-content">{children}</main>
      </div>
    </div>
  );
}

export default RouteWrapper;

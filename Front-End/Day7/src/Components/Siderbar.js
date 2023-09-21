import React from 'react'
import { BiTimer } from 'react-icons/bi';
import { AiFillProfile } from 'react-icons/ai';
import { Link } from 'react-router-dom';
import 
{ BsGrid1X2Fill, BsFillArchiveFill, BsFillGrid3X3GapFill, BsPeopleFill, 
  BsListCheck, BsMenuButtonWideFill, BsFillGearFill,BsFillBarChartFill}
 from 'react-icons/bs'

function Sidebar({openSidebarToggle, OpenSidebar}) {
  return (
    <aside id="sidebar" className={openSidebarToggle ? "sidebar-responsive": ""}>
        <div className='sidebar-title'>
            <div className='sidebar-brand'>
                <BsFillBarChartFill  className='icon_header'/> Employee Board
            </div>
            <span className='icon close_icon' onClick={OpenSidebar}>X</span>
        </div>

        <ul className='sidebar-list'>
        <Link to="/home">  <li className='sidebar-list-item'>
                <a href="">
                    <BsGrid1X2Fill className='icon'/> Dashboard
                </a>
            </li></Link>
            <Link to="/time"> <li className='sidebar-list-item'>
                <a href="">
                    <BiTimer className='icon'/> TimeEntry Sheet
                </a>
            </li></Link>
            <Link to="/manageproject"> <li className='sidebar-list-item'>
                <a href="">
                    <AiFillProfile className='icon'/> Project Management
                </a>
            </li> </Link>
           
            <Link to="/"> <li className='sidebar-list-item'>
                <a href="">
                    <BsMenuButtonWideFill className='icon'/>Log Out
                </a>
            </li>
            </Link>
           
        </ul>
    </aside>
  )
}

export default Sidebar
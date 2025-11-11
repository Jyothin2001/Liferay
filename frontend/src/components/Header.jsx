import React from 'react'
import { Link } from 'react-router-dom'
export default function Header(){return(<div className='header'><div style={{fontWeight:700}}>CompetitionSite</div><div><Link to='/' style={{marginRight:12}}>Home</Link><Link to='/about' style={{marginRight:12}}>About</Link><Link to='/admin'>Admin</Link></div></div>)}
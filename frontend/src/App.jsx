import React from 'react'
import { Routes, Route } from 'react-router-dom'
import PublicHome from './pages/PublicHome'
import PublicAbout from './pages/PublicAbout'
import AdminDashboard from './pages/AdminDashboard'
import Header from './components/Header'
export default function App(){return(<div><Header/><Routes><Route path='/' element={<PublicHome/>}/><Route path='/about' element={<PublicAbout/>}/><Route path='/admin/*' element={<AdminDashboard/>}/></Routes></div>)}
import React, {useEffect, useState} from 'react'
import { Line } from 'react-chartjs-2'
import { Chart as ChartJS, CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend } from 'chart.js'
import axios from 'axios'
ChartJS.register(CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend)

export default function HistoryChart({base='USD', target='INR', days=7}){
  const [series, setSeries] = useState([])

  useEffect(()=>{ fetchSeries() }, [base, target, days])

  const fetchSeries = async () => {
    try{
      const res = await axios.get(`http://localhost:8000/convert/history?base=${base}&target=${target}&days=${days}`)
      if(res.data.success) setSeries(res.data.series)
    }catch(e){
      console.error(e)
    }
  }

  const labels = series.map(s=> s[0])
  const data = {
    labels,
    datasets: [{
      label: `${base} → ${target}`,
      data: series.map(s=> s[1]),
      fill: false,
      tension: 0.2,
    }]
  }

  return (
    <div className="card" style={{marginTop:12}}>
      <h4 className="small">Historical rates</h4>
      <div style={{height:260}}>
        <Line data={data} />
      </div>
    </div>
  )
}

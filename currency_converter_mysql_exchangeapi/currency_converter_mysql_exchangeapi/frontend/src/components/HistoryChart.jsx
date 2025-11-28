import React, { useEffect, useState } from 'react';
import { Line } from 'react-chartjs-2';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend
} from 'chart.js';
import axios from 'axios';
import './HistoricalChart.css';

ChartJS.register(CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend);

export default function HistoryChart({ base = 'USD', target = 'INR', days = 7 }) {
  const [series, setSeries] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [info, setInfo] = useState("");

  useEffect(() => {
    fetchSeries();
  }, [base, target, days]);

  const fetchSeries = async () => {
    setLoading(true);
    setError(null);
    try {
      const res = await axios.get(
        `http://192.168.0.102:8000/convert/history?base=${base}&target=${target}&days=${days}`
      );

      if (res.data.success && Array.isArray(res.data.series)) {
        // Fill missing rates with last known value
        let lastRate = null;
        const filledSeries = res.data.series.map(([date, rate]) => {
          if (rate !== null) lastRate = rate;
          return [date, lastRate];
        });

        setSeries(filledSeries);
        setInfo(res.data.message || "");
      } else {
        setSeries([]);
        setInfo("No data found.");
      }
    } catch (e) {
      console.error("Fetch error:", e);
      setError('Failed to load historical data');
      setSeries([]);
    } finally {
      setLoading(false);
    }
  };

  if (loading) return <div className="history-card">Loading historical chart...</div>;
  if (error) return <div className="history-card">{error}</div>;

  const labels = series.map(s => s[0]);
  const dataValues = series.map(s => s[1]);

  const validRates = dataValues.filter(r => r !== null);
  const minRate = Math.min(...validRates);
  const maxRate = Math.max(...validRates);
  const padding = (maxRate - minRate) * 0.05 || 0.001;

  const data = {
    labels,
    datasets: [
      {
        label: `${base} → ${target}`,
        data: dataValues,
        fill: false,
        tension: 0.3,
        spanGaps: true, // Connect points even if some were null initially
        borderColor: '#3b82f6',
        backgroundColor: '#3b82f6',
        pointRadius: 4,
        pointHoverRadius: 6,
        pointBackgroundColor: '#3b82f6',
      }
    ]
  };

  const options = {
    responsive: true,
    plugins: {
      legend: { position: 'top' },
      tooltip: {
        callbacks: {
          label: ctx => `Rate: ${parseFloat(ctx.raw).toFixed(6)}`
        }
      }
    },
    scales: {
      y: {
        beginAtZero: false,
        suggestedMin: minRate - padding,
        suggestedMax: maxRate + padding,
        ticks: { callback: v => parseFloat(v).toFixed(6) }
      },
      x: {
        ticks: { autoSkip: true, maxTicksLimit: 10 }
      }
    }
  };

  return (
    <div className="history-card">
      <h4 className="history-title">Historical Rates ({base} → {target})</h4>
      {info && <p className="history-info">{info}</p>}
      <div className="history-chart">
        <Line data={data} options={options} />
      </div>
    </div>
  );
}




// import React, { useEffect, useState } from 'react';
// import { Line } from 'react-chartjs-2';
// import { 
//   Chart as ChartJS, 
//   CategoryScale, 
//   LinearScale, 
//   PointElement, 
//   LineElement, 
//   Title, 
//   Tooltip, 
//   Legend 
// } from 'chart.js';
// import axios from 'axios';
// import './HistoricalChart.css';

// ChartJS.register(CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend);

// export default function HistoryChart({ base = 'USD', target = 'INR', days = 7 }) {
//   const [series, setSeries] = useState([]);
//   const [loading, setLoading] = useState(true);
//   const [error, setError] = useState(null);

//   useEffect(() => {
//     fetchSeries();
//   }, [base, target, days]);

//   const fetchSeries = async () => {
//     setLoading(true);
//     setError(null);
//     try {
//       const res = await axios.get(
//         `http://192.168.0.102:8000/convert/history?base=${base}&target=${target}&days=${days}`
//       );
//       if (res.data.success) {
//         setSeries(res.data.series || []);
//       } else {
//         setSeries([]);
//       }
//     } catch (e) {
//       console.error(e);
//       setError('Failed to load historical data');
//       setSeries([]);
//     } finally {
//       setLoading(false);
//     }
//   };

//   const dataValues = series.map(s => parseFloat(s[1]));
//   const labels = series.map(s => s[0]);

//   const data = {
//     labels,
//     datasets: [
//       {
//         label: `${base} → ${target}`,
//         data: dataValues,
//         fill: false,
//         tension: 0.2,
//         borderColor: '#3b82f6',
//         backgroundColor: '#3b82f6',
//       }
//     ]
//   };

//   const options = {
//     responsive: true,
//     plugins: { legend: { position: 'top' } },
//     scales: {
//       y: {
//         beginAtZero: false,
//         suggestedMin: dataValues.length ? Math.min(...dataValues) * 0.99 : 0,
//         suggestedMax: dataValues.length ? Math.max(...dataValues) * 1.01 : 1,
//         ticks: { callback: v => v.toFixed(2) }
//       },
//       x: { ticks: { autoSkip: true, maxTicksLimit: 10 } }
//     }
//   };

//   if (loading) return <div className="history-card">Loading historical chart...</div>;
//   if (error) return <div className="history-card">{error}</div>;

//   return (
//     <div className="history-card">
//       <h4 className="history-title">Historical Rates ({base} → {target})</h4>
//       <div className="history-chart">
//         <Line data={data} options={options} />
//       </div>
//     </div>
//   );
// }



// import React, { useEffect, useState } from 'react';
// import { Line } from 'react-chartjs-2';
// import { 
//   Chart as ChartJS, 
//   CategoryScale, 
//   LinearScale, 
//   PointElement, 
//   LineElement, 
//   Title, 
//   Tooltip, 
//   Legend 
// } from 'chart.js';
// import axios from 'axios';
// import './HistoricalChart.css';

// ChartJS.register(CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend);

// export default function HistoryChart({ base = 'USD', target = 'INR', days = 7 }) {
//   const [series, setSeries] = useState([]);

//   useEffect(() => { fetchSeries() }, [base, target, days]);

//   const fetchSeries = async () => {
//     try {
//       const res = await axios.get(`http://192.168.0.102:8000/convert/history?base=${base}&target=${target}&days=${days}`);
//       if (res.data.success) setSeries(res.data.series);
//     } catch (e) {
//       console.error(e);
//     }
//   };

//   const labels = series.map(s => s[0]);
//   const data = {
//     labels,
//     datasets: [{
//       label: `${base} → ${target}`,
//       data: series.map(s => s[1]),
//       fill: false,
//       tension: 0.2,
//       borderColor: '#3b82f6',       // Blue line
//       backgroundColor: '#3b82f6',   // Points color
//     }]
//   };

//   return (
//     <div className="history-card">
//       <h4 className="history-title">Historical Rates ({base} → {target})</h4>
//       <div className="history-chart">
//         <Line data={data} />
//       </div>
//     </div>
//   );
// }
//  returning the same rate for all days because the free plan of ExchangeRate-API only gives the latest rate,
//  not historical daily rates. That’s why your chart looks like a straight line.




// import React, {useEffect, useState} from 'react'
// import { Line } from 'react-chartjs-2'
// import { Chart as ChartJS, CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend } from 'chart.js'
// import axios from 'axios'
// import'./HistoricalChart.css';
// ChartJS.register(CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend)

// export default function HistoryChart({base='USD', target='INR', days=7}){
//   const [series, setSeries] = useState([])

//   useEffect(()=>{ fetchSeries() }, [base, target, days])

//   const fetchSeries = async () => {
//     try{
//       const res = await axios.get(`http://localhost:8000/convert/history?base=${base}&target=${target}&days=${days}`)
//       if(res.data.success) setSeries(res.data.series)
//     }catch(e){
//       console.error(e)
//     }
//   }

//   const labels = series.map(s=> s[0])
//   const data = {
//     labels,
//     datasets: [{
//       label: `${base} → ${target}`,
//       data: series.map(s=> s[1]),
//       fill: false,
//       tension: 0.2,
//     }]
//   }

//   return (
//     <div className="card" style={{marginTop:12}}>
//       <h4 className="small">Historical rates</h4>
//       <div style={{height:260}}>
//         <Line data={data} />
//       </div>
//     </div>
//   )
// }

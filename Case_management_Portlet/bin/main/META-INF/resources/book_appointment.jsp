<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<%
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
long userId = themeDisplay.getUserId();
long companyId = themeDisplay.getCompanyId();
%>

<div class="container mt-4">
  <h3>🩺 Book Appointment</h3>

  <form id="appointmentForm">
    <input type="hidden" id="companyId" value="<%= companyId %>" />
    <input type="hidden" id="patientId" value="<%= userId %>" />

    <div class="form-group mt-2">
      <label><b>Patient:</b></label>
      <select id="patientSelect" class="form-control"></select>
    </div>

    <div class="form-group mt-2">
      <label><b>Select Doctor:</b></label>
      <select id="doctorSelect" class="form-control"></select>
    </div>

    <div class="form-group mt-2">
      <label><b>Date:</b></label>
      <input type="date" id="appointmentDate" class="form-control" required />
    </div>

    <div class="form-group mt-2">
      <label><b>Time Slot:</b></label>
      <input type="time" id="timeSlot" class="form-control" required />
    </div>

    <div class="form-group mt-3">
      <button type="button" class="btn btn-success" onclick="bookAppointment()">Book Appointment</button>
    </div>
  </form>

  <hr>

  <h4>📅 All Appointments</h4>
  <table class="table table-bordered" id="appointmentsTable">
    <thead>
      <tr>
        <th>ID</th>
        <th>Doctor</th>
        <th>Date</th>
        <th>Time</th>
        <th>Status</th>
      </tr>
    </thead>
    <tbody></tbody>
  </table>
</div>

<script>
const baseUrl = Liferay.ThemeDisplay.getPortalURL() + "/o/appointment-scheduling-headlessAPI/v1.0";

// 🔹 Load doctors list
async function loadDoctors() {
  const res = await fetch(`${baseUrl}/doctors`);
  const data = await res.json();
  const select = document.getElementById("doctorSelect");
  select.innerHTML = "<option value=''>-- Select Doctor --</option>";
  data.items.forEach(d => {
    select.innerHTML += `<option value='${d.doctorId}'>${d.firstName} ${d.lastName} (${d.specialization})</option>`;
  });
}

// 🔹 Load patients list
async function loadPatients() {
  const res = await fetch(`${baseUrl}/patients`);
  const data = await res.json();
  const select = document.getElementById("patientSelect");
  select.innerHTML = "<option value=''>-- Select Patient --</option>";
  data.items.forEach(p => {
    select.innerHTML += `<option value='${p.patientId}'>${p.firstName} ${p.lastName}</option>`;
  });
}

// 🔹 Load all appointments
async function loadAppointments() {
  const res = await fetch(`${baseUrl}/appointments`);
  const data = await res.json();
  const tbody = document.querySelector("#appointmentsTable tbody");
  tbody.innerHTML = "";
  data.items.forEach(a => {
    tbody.innerHTML += `
      <tr>
        <td>${a.appointmentId}</td>
        <td>${a.doctorName || ''}</td>
        <td>${a.appointmentDate || ''}</td>
        <td>${a.timeSlot || ''}</td>
        <td>${a.status || ''}</td>
      </tr>`;
  });
}

// 🔹 Book new appointment
async function bookAppointment() {
  const patientId = document.getElementById("patientSelect").value;
  const doctorId = document.getElementById("doctorSelect").value;
  const appointmentDate = document.getElementById("appointmentDate").value;
  const timeSlot = document.getElementById("timeSlot").value;

  if (!patientId || !doctorId) {
    alert("Please select both patient and doctor.");
    return;
  }

  const res = await fetch(`${baseUrl}/appointments`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      patientId,
      doctorId,
      appointmentDate,
      timeSlot,
      status: "Scheduled"
    })
  });

  if (res.ok) {
    alert("✅ Appointment booked successfully!");
    loadAppointments();
  } else {
    alert("❌ Failed to book appointment.");
  }
}

// Load data when page opens
loadDoctors();
loadPatients();
loadAppointments();
</script>

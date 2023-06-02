// Call the dataTables jQuery plugin
$(document).ready(function() {
//  $('#dataTable').DataTable({});
    $('#dataTable').DataTable({
    "lengthChange": false,
    "searching": true,
    "pageLength": 20
    });
});

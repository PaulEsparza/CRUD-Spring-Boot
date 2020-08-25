function deleteTask(id) {
    swal({
            title: "Are you sure to delete it?",
            text: "Once deleted, you will not be able to recover this imaginary file!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
        .then((ok) => {
            if (ok) {
                $.ajax({
                    url: "/deleteTask/" + id,
                    success: function (res) {
                        console.log(res);
                    }
                });
                swal("Poof! Your imaginary file has been deleted!", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/";
                    }
                });
            } else {
                swal("Your imaginary file is safe!");
            }
        });
}
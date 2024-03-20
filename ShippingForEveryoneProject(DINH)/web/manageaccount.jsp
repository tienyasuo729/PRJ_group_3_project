<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile - Fast Delivery</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .profile-card {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 30px;
        }
        .profile-card .card-title {
            font-size: 24px;
            margin-bottom: 20px;
        }
        .profile-card .card-subtitle {
            color: #888;
            margin-bottom: 20px;
        }
        .profile-card .card-text {
            margin-bottom: 10px;
        }
        .profile-card .fa {
            margin-right: 5px;
        }
        .profile-card .btn-edit-profile {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 20px;
            border-radius: 5px;
            transition: all 0.3s;
        }
        .profile-card .btn-edit-profile:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="profile-card">
                    <h2 class="card-title">User Profile</h2>
                    <p class="card-subtitle">Manage your personal information</p>
                    <div class="card-text">
                        <p><strong>Name:</strong> John Doe</p>
                        <p><strong>Email:</strong> john@example.com</p>
                        <p><strong>Phone:</strong> 123-456-7890</p>
                        <p><strong>Address:</strong> 123 Main Street, City, Country</p>
                    </div>
                    <a href="#" class="btn btn-edit-profile"><i class="fas fa-edit"></i> Edit Profile</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Font Awesome JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
</body>
</html>

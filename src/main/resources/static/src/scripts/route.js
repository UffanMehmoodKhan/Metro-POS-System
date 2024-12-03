const routes = {
    //initital  screen routes
    splash: 'splash.html',
    LoginType: 'LoginTypeScreen.html',
    //cashier routes
    login: 'CashierLogin.html',
    cashierDashboard: 'CashierDashboard.html',
    //super Admin routes
    superAdminLogin:'SuperAdminLogin.html',
    superAdminDashboard:'SuperAdminDashboard.html',
    //data entry operator routes
    dataoperatorLogin:'DataEntryOperatorLogin.html',
    dataoperatorDashboard:'DataEntryOperatorDashboard.html',
    //Branch Manager Routes
    branchManagerLogin:'BranchManagerLogin.html',
    branchManagerDashboard:'BranchManagerDashboard.html'

};

// Function to navigate to the splash screen
function navigateToSplash() {
    setTimeout(() => {
        window.location.href = routes.LoginType; // Redirect to LoginTypeScreen after 5 seconds
    }, 5000); // 5 seconds delay for splash screen
}

// If we're on the splash page, start navigation after 5 seconds
if (window.location.pathname.includes('splash.html')) {
    navigateToSplash(); // Navigate to LoginTypeScreen after splash
}

// Handle navigation for LoginTypeScreen buttons
if (window.location.pathname.includes('LoginTypeScreen.html')) {
    // Super Admin button click
    document.getElementById("superAdminButton").addEventListener("click", function() {
        window.location.href = routes.superAdminLogin; // Navigate to the Super Admin  login portal
    });

    // Cashier button click
    document.getElementById("cashierButton").addEventListener("click", function() {
        window.location.href = routes.login; // Navigate to login.html for Cashier
    });

    // Data Entry button click
    document.getElementById("dataEntryButton").addEventListener("click", function() {
        window.location.href = routes.dataoperatorLogin; // Navigate to the Data entry opeartor login portal
    });

    // Branch Manager button click
    document.getElementById("branchManagerButton").addEventListener("click", function() {
        window.location.href = routes.branchManagerLogin; // Navigate to the Branch manager login portal
    });
}

// Function for validation of credentials for cashier
if (window.location.pathname.includes('CashierLogin.html')) {
    // Hardcoded credentials for the cashier
    const validCashierCredentials = {
        username: 'ali@gmail.com', 
        password: '123',          
        branchId: '1111'            
    };

    // Handle login form submission
    const loginButton = document.getElementById('loginBtn'); // Get the login button by id
    if (loginButton) {
        loginButton.addEventListener('click', function() {
            // Get the values from the form fields using their IDs
            const usernameInput = document.getElementById('cashierUsername').value.trim(); // Email/Username input
            const passwordInput = document.getElementById('cashierPassword').value.trim(); // Password input
            const branchIdInput = document.getElementById('cashierBranchId').value.trim(); // Branch-ID input


            // Check if the entered credentials match the hardcoded cashier credentials
            if (
                usernameInput === validCashierCredentials.username &&
                passwordInput === validCashierCredentials.password &&
                branchIdInput === validCashierCredentials.branchId
            ) {
                window.location.href = routes.cashierDashboard; // Redirect to Cashier Dashboard on successful login
            } else {
                alert('Invalid credentials! Please try again.'); // Show error message on invalid credentials
            }
        });
    }
}

// Function for validation of credentials for superAdmin
if (window.location.pathname.includes('SuperAdminLogin.html')) {
    // Hardcoded credentials for the Super Admin
    const validSuperAdminCredentials = {
        username: 'alisuperAdmin', 
        password: '999',          
        securityCode: '224455' // 13-digit security code
    };

    // Handle login form submission
    const loginButton = document.getElementById('superAdminLoginBtn'); // Get the login button by id
    if (loginButton) {
        loginButton.addEventListener('click', function() {
            // Get the values from the form fields using their IDs
            const usernameInput = document.getElementById('superAdminUsername').value.trim(); // Username input
            const passwordInput = document.getElementById('superAdminPassword').value.trim(); // Password input
            const securityCodeInput = document.getElementById('superAdminSecurityCode').value.trim(); // Security Code input

          
            // Check if the entered credentials match the hardcoded Super Admin credentials
            if (
                usernameInput === validSuperAdminCredentials.username &&
                passwordInput === validSuperAdminCredentials.password &&
                securityCodeInput === validSuperAdminCredentials.securityCode
            ) {
                window.location.href = routes.superAdminDashboard;
            } else {
                alert('Invalid credentials! Please try again.'); 
            }
        });
    }
}

//function for validation of credentials for Branch Manager
if (window.location.pathname.includes('BranchManagerLogin.html')) {
    // Hardcoded credentials for the Branch Manager
    const validBranchManagerCredentials = {
        username: 'branchManager@gmail.com', 
        password: '12345'
    };

    // Handle login form submission
    const loginButton = document.getElementById('BranchManagerlgnBtn'); // Get the login button by id
    if (loginButton) {
        loginButton.addEventListener('click', function() {
            // Get the values from the form fields
            const usernameInput = document.getElementById('branchManagerUsername').value.trim(); // Use the id selector
            const passwordInput = document.getElementById('branchManagerPassword').value.trim(); // Use the id selector

            // Check if the entered credentials match the hardcoded Branch Manager credentials
            if (usernameInput === validBranchManagerCredentials.username && passwordInput === validBranchManagerCredentials.password) {
                window.location.href = routes.branchManagerDashboard; // Redirect to Branch Manager Dashboard on successful login
            } else {
                alert('Invalid credentials! Please try again.'); // Show error message on invalid credentials
            }
        });
    }
}
//function for validation of credentials for data Entry operator
if (window.location.pathname.includes('DataEntryOperatorLogin.html')) {
    // Hardcoded credentials for the Data Entry Operator
    const validDataEntryOpeartorCredentials = {
        username: 'dataEntryOperator@gmail.com', 
        password: '123456',          
        securityCode: '2222' // 4-digit security code
    };

    // Handle login form submission
    const loginButton = document.getElementById('DataEntrylgnBtn'); // Get the login button by id
    if (loginButton) {
        loginButton.addEventListener('click', function() {
            // Get the values from the form fields
            const usernameInput = document.getElementById('dataEntryUsername').value.trim(); // Username input
            const passwordInput = document.getElementById('dataEntryPassword').value.trim(); // Password input
            const securityCodeInput = document.getElementById('dataEntrySecurityCode').value.trim(); // Security Code input

            // Check if the entered credentials match the hardcoded Data Entry Operator credentials
            if (
                usernameInput === validDataEntryOpeartorCredentials.username &&
                passwordInput === validDataEntryOpeartorCredentials.password &&
                securityCodeInput === validDataEntryOpeartorCredentials.securityCode
            ) {
                window.location.href = routes.dataoperatorDashboard; // Redirect to Data Entry Operator Dashboard on successful login
            } else {
                alert('Invalid credentials! Please try again.'); // Show error message on invalid credentials
            }
        });
    }
}


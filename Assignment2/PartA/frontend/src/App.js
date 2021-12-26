import {BrowserRouter,Route,Switch} from 'react-router-dom';
import './App.css';
import Navbar from './components/navbar';
import Login from './components/login';
import Register from './components/register';
import Users from './components/users';

function App() {
  return (
    <div>
      <Navbar />
      <BrowserRouter>
        <Switch>
        <Route path="/login" component={Login}>
            <Login></Login>
          </Route>
          <Route path="/register" component={Register}>
            <Register></Register>
          </Route>
          <Route path="/users" component={Users}>
            <Users></Users>  
          </Route>  
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;

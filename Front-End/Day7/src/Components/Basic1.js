import React, { useState } from 'react';
import './Basic1.css';

function Manageproject() {
  const [projects, setProjects] = useState([]);
  const [tasks, setTasks] = useState([]);
  const [employees, setEmployees] = useState([]);
  const [assignedTasks, setAssignedTasks] = useState([]);
  const [selectedEmployee, setSelectedEmployee] = useState('');
  const [taskDescription, setTaskDescription] = useState('');
  const [assignedTaskId, setAssignedTaskId] = useState('');
  const [projectName, setProjectName] = useState('');
  const [projectDescription, setProjectDescription] = useState('');
  const [employeeName, setEmployeeName] = useState('');

  const addProject = (projectName) => {
    // Check if a project with the same name already exists
    const projectExists = projects.some((project) => project.name === projectName);

    if (!projectExists) {
      const newProject = { id: Date.now(), name: projectName, description: projectDescription };
      setProjects([...projects, newProject]);
      setProjectName('');
      setProjectDescription('');
    }
  };

  const addTask = (taskName) => {
    const newTask = { id: Date.now(), name: taskName, description: '' };
    setTasks([...tasks, newTask]);
  };

  const addProjectOnBlur = (e) => {
    const projectName = e.target.value.trim();
    if (projectName) {
      addProject(projectName);
      e.target.value = '';
    }
  };

  const addTaskOnBlur = (e) => {
    const taskName = e.target.value.trim();
    if (taskName) {
      addTask(taskName);
      e.target.value = '';
    }
  };

  const addEmployee = (employeeName) => {
    // Check if an employee with the same name already exists
    const employeeExists = employees.some((employee) => employee.name === employeeName);

    if (!employeeExists) {
      const newEmployee = { id: Date.now(), name: employeeName };
      setEmployees([...employees, newEmployee]);
      setEmployeeName('');
    }
  };

  const assignTask = () => {
    if (assignedTaskId && selectedEmployee) {
      const assignment = {
        taskId: assignedTaskId,
        employeeId: selectedEmployee,
      };
      setAssignedTasks([...assignedTasks, assignment]);
      setAssignedTaskId('');
    }
  };

  const updateTaskDescription = (taskId, description) => {
    const updatedTasks = tasks.map((task) =>
      task.id === taskId ? { ...task, description } : task
    );
    setTasks(updatedTasks);
  };

  const deleteTask = (taskId) => {
    const updatedTasks = tasks.filter((task) => task.id !== taskId);
    setTasks(updatedTasks);
  };

  return (
    <div className="App">
      <h1>Project and Task Management</h1>
      <ProjectList projects={projects} addProject={addProject} addProjectOnBlur={addProjectOnBlur} />
      
      <TaskList
        tasks={tasks}
        employees={employees}
        updateTaskDescription={updateTaskDescription}
        deleteTask={deleteTask}
        addTask={addTask}
        addTaskOnBlur={addTaskOnBlur}
      />
      <EmployeeList
        employees={employees}
        setSelectedEmployee={setSelectedEmployee}
        addEmployee={addEmployee}
        employeeName={employeeName}
        setEmployeeName={setEmployeeName}
      />
      <EmployeeTasksPage
        selectedEmployee={selectedEmployee}
        assignedTaskId={assignedTaskId}
        setAssignedTaskId={setAssignedTaskId}
        taskDescription={taskDescription}
        setTaskDescription={setTaskDescription}
        assignTask={assignTask}
        tasks={tasks}
      />

      <DetailsTable
        projects={projects}
        tasks={tasks}
        employees={employees}
        assignedTasks={assignedTasks}
      />
    </div>
  );
}

function ProjectList({ projects, addProject, addProjectOnBlur }) {
  return (
    <div className="project-list">
      <h2>Projects</h2>
      <ul>
        {projects.map((project) => (
          <li key={project.id}>
            {project.name} - {project.description}
          </li>
        ))}
      </ul>
      <input
        type="text"
        placeholder="New Project Name"
        onBlur={addProjectOnBlur}
      />
    </div>
  );
}

function TaskList({
  tasks,
  employees,
  updateTaskDescription,
  deleteTask,
  addTask,
  addTaskOnBlur,
}) {
  return (
    <div className="task-list">
      <h2>Tasks</h2>
      <ul>
        {tasks.map((task) => (
          <li key={task.id}>
            {task.name} - {task.description}
            <button onClick={() => updateTaskDescription(task.id, prompt('Enter new description:'))}>
              Update
            </button>
            <button onClick={() => deleteTask(task.id)}>Delete</button>
          </li>
        ))}
      </ul>
      <input
        type="text"
        placeholder="New Task Name"
        onBlur={addTaskOnBlur}
      />
    </div>
  );
}

function EmployeeList({ employees, setSelectedEmployee, addEmployee, employeeName, setEmployeeName }) {
  return (
    <div className="employee-list">
      <h2>Employees</h2>
      <ul>
        {employees.map((employee) => (
          <li key={employee.id}>
            {employee.name}
            <button onClick={() => setSelectedEmployee(employee.id)}>Select</button>
          </li>
        ))}
      </ul>
      <input
        type="text"
        placeholder="New Employee Name"
        value={employeeName}
        onChange={(e) => setEmployeeName(e.target.value)}
      />
      <button onClick={() => addEmployee(employeeName)}>Add Employee</button>
    </div>
  );
}

function EmployeeTasksPage({
  selectedEmployee,
  assignedTaskId,
  setAssignedTaskId,
  taskDescription,
  setTaskDescription,
  assignTask,
  tasks,
}) {
  return (
    <div className="employee-tasks-page">
      <h2>Employee Task Management</h2>
      <select
        onChange={(e) => setAssignedTaskId(e.target.value)}
        value={assignedTaskId}
      >
        <option value="">Select a Task</option>
        {tasks.map((task) => (
          <option key={task.id} value={task.id}>
            {task.name}
          </option>
        ))}
      </select>
      <button onClick={assignTask}>Assign Task</button>

      <h3>Task Description</h3>
      <textarea
        rows="4"
        value={taskDescription}
        onChange={(e) => setTaskDescription(e.target.value)}
      />
    </div>
  );
}

function DetailsTable({ projects, tasks, employees, assignedTasks }) {
  return (
    <div className="details-table">
      <h2>Entered Details</h2>
      <table>
        <thead>
          <tr>
            <th>Projects</th>
            <th>Tasks</th>
            <th>Employees</th>
            
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>
              <ul>
                {projects.map((project) => (
                  <li key={project.id}>
                    {project.name}  {project.description}
                  </li>
                ))}
              </ul>
            </td>
            <td>
              <ul>
                {tasks.map((task) => (
                  <li key={task.id}>
                    {task.name}  {task.description}
                  </li>
                ))}
              </ul>
            </td>
            <td>
              <ul>
                {employees.map((employee) => (
                  <li key={employee.id}>{employee.name}</li>
                ))}
              </ul>
            </td>
            
          </tr>
        </tbody>
      </table>
    </div>
  );
}


export default Manageproject;
